# Sistema de Automatizacion de Pruebas

Proyecto de automatizacion de pruebas desarrollado con Java 17 y Maven, aplicando conceptos de integracion continua, pruebas unitarias atomicas, BDD y testing de performance.

## Caracteristicas

- **Pruebas Unitarias**: JUnit 5 con pruebas atomicas e independientes
- **BDD (Behavior Driven Development)**: Cucumber con Gherkin para especificaciones ejecutables
- **Pruebas de Performance**: k6 para pruebas de carga y rendimiento
- **Integracion Continua**: GitHub Actions pipeline automatizado
- **Reporting**: Reportes HTML navegables de resultados de pruebas
- **Alertas Automaticas**: Notificaciones via GitHub Actions
- **Dashboard**: GitHub Insights para metricas

## Estructura del Proyecto

```
sistema-auto/
├── src/
│   ├── main/java/com/automatizacion/
│   │   └── Calculadora.java        # Codigo de produccion
│   ├── test/
│       ├── java/com/automatizacion/
│       │   ├── CalculadoraTest.java    # Pruebas unitarias
│       │   ├── steps/LoginSteps.java   # Step definitions BDD
│       │   └── runner/TestRunner.java  # Runner Cucumber
│       ├── resources/features/
│       │   └── login.feature           # Escenarios Gherkin
│       └── performance/
│           └── login-perf.js           # Script k6 performance
├── .github/workflows/
│   └── ci.yml                      # Pipeline CI/CD
├── pom.xml                         # Configuracion Maven
└── README.md                       # Este archivo
```

## Requisitos

- Java JDK 17 o superior
- Maven 3.8+
- k6 (para pruebas de performance locales)

## Instalacion y Ejecucion

```bash
# Clonar el repositorio
git clone <url-repositorio>
cd sistema-auto

# Compilar el proyecto
mvn clean compile

# Ejecutar pruebas unitarias
mvn test

# Ejecutar pruebas BDD
mvn test -Dcucumber.filter.tags=@login

# Generar reporte HTML
mvn verify -DskipTests

# Ejecutar test de performance (local)
curl -sL https://github.com/grafana/k6/releases/download/v0.46.0/k6-v0.46.0-linux-amd64.tar.gz | tar xz
./k6-v0.46.0-linux-amd64/k6 run src/test/performance/login-perf.js
```

## Pipeline CI/CD

El proyecto incluye un pipeline de GitHub Actions configurado en `.github/workflows/ci.yml` que:

### 1. Se ejecuta automaticamente en:
- Push a ramas `main` o `feature/*`
- Pull requests a `main`

### 2. Ejecuta:
- Checkout del codigo
- Configuracion de Java 17
- Ejecucion de pruebas unitarias (JUnit 5)
- Ejecucion de pruebas BDD (Cucumber)
- Ejecucion de pruebas de performance (k6)
- Generacion de reportes Surefire y Cucumber
- Verificacion de resultados
- Publicacion de artifacts

### 3. Reportes disponibles:
- **test-reports**: XML de Surefire (pruebas unitarias)
- **cucumber-html-report**: HTML navegable de BDD
- **performance-results**: JSON de metricas k6

### 4. Dashboard:
- GitHub: Repository > Insights > Metrics

### 5. Alertas:
- Notificaciones automaticas por email via GitHub Actions

---

## Pruebas Unitarias

El proyecto cuenta con 2 pruebas unitarias atomicas:

| Test | Descripcion | Expected |
|------|-------------|----------|
| testSumar | Verifica suma de enteros | 5 + 3 = 8 |
| testRestar | Verifica resta de enteros | 10 - 4 = 6 |

---

## Pruebas BDD (Cucumber)

El proyecto cuenta con escenarios Gherkin para autenticacion de usuario:

### Feature: Login
- **Tag**: @login
- **Escenarios**: 3 (2 scenarios + 1 scenario outline con 4 examples)
- **Total casos de prueba**: 6

### Escenarios:
1. Login exitoso con credenciales validas
2. Login fallido con password incorrecto
3. Login con diferentes combinaciones (Scenario Outline)

---

## Pruebas de Performance (k6)

### Script: `src/test/performance/login-perf.js`

Configuracion de carga:
- Ramp-up: 30 segundos (0 a 10 usuarios)
- Steady: 1 minuto (10 usuarios)
- Ramp-down: 30 segundos (10 a 0 usuarios)

### Metricas Monitoreadas:

| Metrica | Descripcion | Umbral Objetivo |
|---------|-------------|-----------------|
| **TPS** | Throughput (solicitudes por segundo) | > 10 req/s |
| **Latencia p95** | 95% de respuestas mas rapidas | < 500ms |
| **Latencia p99** | 99% de respuestas mas rapidas | < 1000ms |
| **Tasa de errores** | Porcentaje de respuestas con error | < 1% |
| **Tiempo promedio** | Duracion media de respuesta | < 300ms |

---

## Conceptos Aplicados

| Concepto | Implementacion |
|----------|----------------|
| **Integracion Continua** | Pipeline CI ejecuta tests en cada push/PR |
| **Atomicidad** | Tests independientes, sin dependencias externas |
| **BDD** | Cucumber con Gherkin, escenarios ejecutables |
| **M Surefire** | Genera: Tests ejecutados, fallos, tiempo de ejecucion |
| **Reporting** | Reportes XML/HTML/JSON accesibles al equipo |
| **Performance Testing** | k6 con metricas de carga y latencia |
| **Alertas** | Notificaciones automaticas via GitHub |
| **Trabajo Colaborativo** | Ramas feature + PR workflow |

---

## Configuracion Maven

### Dependencias
- JUnit Jupiter 5.10.0 (scope: test)
- Cucumber Java 7.18.0
- Cucumber JUnit Platform Engine 7.18.0
- Cucumber Reporting 5.8.0

### Plugins
- maven-surefire-plugin 3.1.2
- maven-site-plugin 3.12.1
- maven-cucumber-reporting 5.8.0

---

## Contribucion

1. Crear rama feature: `git checkout -b feature/nueva-funcionalidad`
2. Realizar cambios y agregar tests
3. Ejecutar pruebas localmente: `mvn test`
4. Push y crear Pull Request

---

## Licencia

Este proyecto es con fines educativos.