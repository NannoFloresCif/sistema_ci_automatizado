# Sistema de Automatizacion de Pruebas

Proyecto de automatizacion de pruebas desarrollado con Java 17 y Maven, aplicando conceptos de integracion continua, pruebas unitarias atomicas y reporting.

## Caracteristicas

- **Pruebas Unitarias**: JUnit 5 con pruebas atomicas e independientes
- **Integracion Continua**: GitHub Actions pipeline automatizado
- **Reporting**: Reportes HTML navegables de resultados de pruebas
- **Buenas Practicas**: Estructura Maven estandar, .gitignore completo

## Estructura del Proyecto

```
sistema-auto/
├── src/
│   ├── main/java/com/automatizacion/
│   │   └── Calculadora.java        # Codigo de produccion
│   └── test/java/com/automatizacion/
│       └── CalculadoraTest.java    # Pruebas unitarias
├── .github/workflows/
│   └── ci.yml                      # Pipeline CI/CD
├── pom.xml                         # Configuracion Maven
└── README.md                       # Este archivo
```

## Requisitos

- Java JDK 17 o superior
- Maven 3.8+

## Instalacion y Ejecucion

```bash
# Clonar el repositorio
git clone <url-repositorio>
cd sistema-auto

# Compilar el proyecto
mvn clean compile

# Ejecutar pruebas
mvn test

# Generar reporte HTML
mvn surefire-report:report

# Generar sitio completo
mvn site
```

## Pipeline CI/CD

El proyecto incluye un pipeline de GitHub Actions configurado en `.github/workflows/ci.yml` que:

1. **Se ejecuta automaticamente** en:
   - Push a ramas `main` o `feature/*`
   - Pull requests a `main`

2. **Ejecuta**:
   - Checkout del codigo
   - Configuracion de Java 17
   - Ejecucion de `mvn clean test`
   - Generacion de reporte Surefire
   - Publicacion de artifacts

3. **Reportes disponibles**:
   - Reporte XML en `target/surefire-reports/`
   - artifacts descargables en GitHub Actions

## Pruebas Unitarias

El proyecto cuenta con 2 pruebas unitarias atomicas:

| Test | Descripcion | Expected |
|------|-------------|----------|
| testSumar | Verifica suma de enteros | 5 + 3 = 8 |
| testRestar | Verifica resta de enteros | 10 - 4 = 6 |

Las pruebas siguen el patron AAA (Arrange-Act-Assert) y son **independientes** entre si.

## Conceptos Aplicados

| Concepto | Implementacion |
|----------|----------------|
| **Integracion Continua** | Pipeline CI ejecuta tests en cada push/PR |
| **Atomicidad** | Tests independientes, sin dependencias externas |
| **M Surefire** | Genera: Tests ejecutados, fallos, tiempo de ejecucion |
| **Reporting** | Reportes XML/HTML accesibles al equipo |
| **Trabajo Colaborativo** | Ramas feature + PR workflow |

## Configuracion Maven

### Dependencias
- JUnit Jupiter 5.10.0 (scope: test)

### Plugins
- maven-surefire-plugin 3.1.2
- maven-site-plugin 3.12.1

## Contribucion

1. Crear rama feature: `git checkout -b feature/nueva-funcionalidad`
2. Realizar cambios y agregar tests
3. Ejecutar pruebas localmente: `mvn test`
4. Push y crear Pull Request

## Licencia

Este proyecto es con fines educativos.