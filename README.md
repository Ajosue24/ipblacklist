# ipblacklist
Challenge technical MELI

INF: Para la solucion se plantearon y se ejecutaron los siguientes elementos 

* Redis para almacenar request y response a apis externas 
* BD H2 para capturar la blacklist
* Swagger para la documentacion 
* Moshi para maejo de json
* Anotaciones de Scheduling parametrizable para reinicio de inf capturada en redis
* Lombok para facil manejo de la data
* Guava para validar direcciones IP
* Uso de WebClient(webflux) para consumir apis externas 
* Docker para despliegue de la aplicacion
* nginx para redireccionar las peticiones
   
    
  Se anexa carpeta postman para importar los recursos que se usaron para pruebas en el desarrollo
  
    
Para ejecutar el proyecto se debe de ejecutar deployDocker.sh
o simplemente 

* docker build -t "ipblacklist" .
* docker-compose up -d
* docker logs -f --tail 5 ipblacklist

Premisa
Para coordinar acciones de respuesta ante fraudes, es útil tener disponible información
contextual del lugar de origen detectado en el momento de comprar, buscar y pagar. Para
ello se decide crear una herramienta que dada una IP obtenga información asociada.
El ejercicio consiste en construir una API Rest que permita:
1. Dada una dirección IP, encontrar el país al que pertenece y mostrar:
a. El nombre y código ISO del país
b. Moneda local y su cotización actual en dólares o euros.
2. Ban/Blacklist de una IP: marcar la ip en una lista negra no permitiéndole consultar el
la información del punto 1.
Observaciones: Tener en cuenta que el punto 1 puede recibir fluctuaciones agresivas de
tráfico.
Para obtener la información, pueden utilizarse las siguientes APIs públicas:
● Geolocalización de IPs: https://ip2country.info/
● Información de paises: http://restcountries.eu/
● Información sobre monedas: http//fixer.io/
Consideraciones
● Se solicita una solución con un diseño OOP.
● La solución debe ser en Java, Kotlin o Groovy.
● Incluir tests que aseguren el correcto funcionamiento de la API. Idealmente de caja
blanca (unitarios) y caja negra (end to end / funcionales).
● Es deseable que la aplicación pueda correr, ser construida y ejecutada dentro de un
contenedor Docker (incluir un Dockerfile e instrucciones para ejecutarlo).
● La aplicación deberá hacer un uso racional de las APIs, evitando hacer llamadas
innecesarias.
● La aplicación no deberá perder su estado ante un shutdown.
● Además de funcionamiento, prestar atención al estilo y calidad del código fuente



  
  
