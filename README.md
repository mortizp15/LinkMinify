# LinkMinify: Acortador de URLs

## Descripción ✏
LinkMinify es un servicio de acortamiento de URLs. Es un proyecto con características base, es mi primer trabajo fullstack así que, espero que os guste tanto como me gustó a mi desarrollarlo.

## Tecnologías Usadas 🌐
### Backend 
- **Spring Boot** para la lógica, aprovechando su inversión de control y su sistema de configuración automática para simplificar el desarrollo de la aplicación.
- **PostgreSQL** como sistema de gestión de base de datos, elegido por su fiabilidad y soporte para grandes volumenes de datos.
### Frontend
- **React** para crear una interfaz sencilla y dinámica.
### Despliegue
- **AWS** para el despliegue y manejo de infraestructura:
   - EC2 aloja la API, asegurando su disponibilidad y escalabilidad.
   - RDS gestiona la base de datos PostgreSQL, ofreciendo copias de seguridad y mantenimiento automáticos.
   - Route53 maneja el dominio y el DNS con el que se genera el URL acortado.
- **NGINX** actua como un proxy inverso, mejorando la seguridad y la gestión del tráfico hacia la API.

## Desafíos Enfrentados ✔
- Durante el desarrollo de LinkMinify, me he enfrentado a varios desafíos, como por ejemplo la configuración del proxy inverso con NGINX para redirigir adecuadamente las peticiones, y asegurar la comunicacion entre el frontend y el backend. La solución implicó estar horas investigando ya que nunca había tocado el tema de los proxys inversos.
- Otro de los desafíos enfrentados, fue la configuracion de la infraestructura en AWS. Ya tenía conocimientos sobre instancias EC2, grupos de seguridad... pero nunca había montado un sistema de despliegue para una aplicación web. La solución estuvo en guiarme a través de la documentación de AWS y foros de internet.

## ¿Cómo lo pruebo? 💻
Para utilizar LinkMinify, basta con acceder a la [página de LinkMinify](https://65f21a8aa7ffb33469c2ecc1--keen-babka-f222ef.netlify.app/)

## Contacto 📩
Si te ha gustado mi proyecto y quieres comentarme alguna mejora, crítica constructiva o simplemente quieres charlar, aquí te dejo mi información:
- LinkedIn: [manuel-ortiz-4ba1442a1](https://www.linkedin.com/in/manuel-ortiz-4ba1442a1/)
- Gmail: [maortizpelegrin@gmail.com](mailto:maortizpelegrin@gmail.com)


