package com.mortizp.linkminify.services;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mortizp.linkminify.exceptions.BadRequestException;
import com.mortizp.linkminify.exceptions.ConflictException;
import com.mortizp.linkminify.exceptions.NotFoundException;
import com.mortizp.linkminify.model.ShortenedUrls;
import com.mortizp.linkminify.repositories.IShortenedUrlsRepository;


@Service
public class ShortenedUrlsServiceImpl implements IShortenedUrlsService {

    private IShortenedUrlsRepository iShortenedUrlsRepository;

    public ShortenedUrlsServiceImpl(IShortenedUrlsRepository iShortenedUrlsRepository) {
        this.iShortenedUrlsRepository = iShortenedUrlsRepository;
    }


    public ShortenedUrls findByUrls(String url) {
        return iShortenedUrlsRepository.findByOriginalUrl(url);
    }

    public ShortenedUrls findByShortcode(String shortCode) {
        ShortenedUrls shortenedUrl = iShortenedUrlsRepository.findByShortcode(shortCode);

        if(shortenedUrl == null) {
            throw new NotFoundException("El enlace no existe o ha caducado");
        }

        return shortenedUrl;
    }
    
    public String createShortenedUrl(String urlToShort) {

        ShortenedUrls urlActual = findByUrls(urlToShort);
        Boolean isValidUrl = isValidURL(urlToShort);

        if(urlActual != null) {
            throw new ConflictException("El url ya ha sido cortado, prueba con otro");
        }
        if(!isValidUrl) {
            throw new BadRequestException("El formato del URL no es correcto, debe ser un URL funcional");
        }


        // Instancia de la entidad ShortenedUrls
        ShortenedUrls shortenedUrl = new ShortenedUrls();

        // Agregar el URL original a la instancia
        shortenedUrl.setOriginalUrl(urlToShort);

        // Establecer shortcode
        shortenedUrl.setShortcode(generateShortcode());

        // Fecha de creacion
        shortenedUrl.setCreatedAt(LocalDateTime.now());

        // Fecha de expiracion
        shortenedUrl.setExpiresAt(LocalDateTime.now().plusMonths(6));

        iShortenedUrlsRepository.save(shortenedUrl);

        // Inserción
        return shortenedUrl.getShortcode();
    }

    public String generateShortcode() {

        // Crear una instancia de la clase Random
        Random random = new Random();
        
        // Definir la cadena de caracteres a usar (números y letras)
        String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";

        // Definir la longitud del código deseado
        int longitudCodigo = 5;
        
        // Usar StringBuilder para construir el código
        StringBuilder codigo = new StringBuilder(longitudCodigo);
        
        // Generar el código de longitud especificada
        for (int i = 0; i < longitudCodigo; i++) {
            // Generar un índice aleatorio para seleccionar un carácter
            int indiceAleatorio = random.nextInt(caracteres.length());
            
            // Añadir el carácter seleccionado al código
            codigo.append(caracteres.charAt(indiceAleatorio));
        }

        return codigo.toString();
    }

    // Validad si el input es un URL
    public boolean isValidURL(String urlStr) {
        try {
            new URL(urlStr);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    // Incrementar el contador de accesos al URL
    public void incrementAccessCount(String shortcode) {
        ShortenedUrls shortenedUrls = iShortenedUrlsRepository.findByShortcode(shortcode);
        if(shortenedUrls != null) {
            shortenedUrls.incrementAccessCount();
            iShortenedUrlsRepository.save(shortenedUrls);
        }
    }

    // Eliminar enlaces caducados
    @Scheduled(cron = "0 0 1 * * ?") // Ejecutar todos los dias a la 1 AM
    public void deleteExpiratedShortenedUrls() {
        iShortenedUrlsRepository.deleteByExpiresAtBefore(LocalDateTime.now());
    }
}
