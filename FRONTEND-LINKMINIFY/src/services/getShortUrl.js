
export async function getShortUrl(url) {
    const response = await fetch("", {
        method: "POST",
        headers: {
            "Content-Type": "text/plain"
        },
        body: url
    })

    if(!response.ok) {
        throw new Error("La repuesta no ha sido 'ok'")
    }

    const data = await response.text();
    return data;
}