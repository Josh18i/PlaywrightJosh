# Proyecto de Prueba de Automatización con Selenium y Cucumber

Este proyecto es una prueba de automatización de una aplicación web utilizando Selenium y Cucumber. Está diseñado para facilitar la comprensión de las pruebas automatizadas y su implementación en entornos de desarrollo.

## Requisitos

- **Java**: Este proyecto utiliza **Java 8**.
- **Maven**: Asegúrate de tener Maven instalado para manejar las dependencias y construir el proyecto.
- **Chrome**: Se requiere el navegador **Google Chrome** para ejecutar las pruebas.
  
## Verificación de ChromeDriver

Es importante verificar que la versión de **ChromeDriver** sea compatible con la versión de **Google Chrome** instalada en tu sistema. Para hacerlo:

1. Abre Google Chrome y ve a `chrome://version/` para verificar la versión actual de Chrome.
2. Descarga la versión correspondiente de ChromeDrive.
3. Si es necesario, modifica la ruta de ChromeDriver en tu configuración de proyecto.
4. Ruta de ChromeDriver en el proyecto src/test/resources/chromedriver/chromedriver.exe

## Dependencias

Las principales dependencias de este proyecto incluyen:

- **Selenium**: Para la automatización del navegador con patron POM.
- **Cucumber**: Para la definición de pruebas utilizando el enfoque BDD (Behavior Driven Development).
