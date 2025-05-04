# Runnerz - Running Activity Tracker

Runnerz is a Spring Boot application that allows users to track their running activities. This REST API enables creating, reading, updating, and deleting information about runs, including details such as distance, duration, location, and more.

## Features

- **Run Management**: Create, retrieve, update, and delete run records
- **Data Persistence**: Store run data in a PostgreSQL database
- **API Endpoints**: RESTful API for interacting with the application
- **Validation**: Input validation to ensure data integrity
- **JSON Data Loading**: Sample run data loaded from JSON on application startup

## Technology Stack

- **Java 17**
- **Spring Boot 3.4.5**
- **Spring Data JDBC**: For database interaction
- **PostgreSQL**: For data persistence
- **Maven**: For dependency management
- **Docker Compose**: For running the PostgreSQL database

## Project Structure

```
runnerz/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── dev/mohamed/runnerz/
│   │   │       ├── run/                 # Run-related components
│   │   │       │   ├── Run.java         # Run entity
│   │   │       │   ├── RunController.java # API endpoints
│   │   │       │   ├── RunRepository.java # Data access
│   │   │       │   └── ...
│   │   │       ├── user/                # User-related components
│   │   │       │   ├── User.java        # User entity
│   │   │       │   ├── UserHTTPClient.java # External API client
│   │   │       │   └── ...
│   │   │       └── RunnerzApplication.java # Main application class
│   │   └── resources/
│   │       ├── application.properties   # Application configuration
│   │       ├── schema.sql               # Database schema
│   │       └── data/
│   │           └── runs.json            # Sample run data
│   └── test/                            # Test classes
├── api/                                 # API documentation
│   ├── runnerz.http                     # HTTP request examples
│   └── runnerz-postman-collection.json  # Postman collection
├── compose.yaml                         # Docker Compose configuration
├── mvnw                                 # Maven wrapper script (Unix)
├── mvnw.cmd                             # Maven wrapper script (Windows)
└── pom.xml                              # Maven project configuration
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Docker and Docker Compose (for running PostgreSQL)
- Maven (optional, as the project includes Maven wrapper)

### Setup and Installation

1. **Clone the repository**

```bash
git clone https://github.com/yourusername/runnerz.git
cd runnerz
```

2. **Start the PostgreSQL database using Docker Compose**

```bash
docker-compose up -d
```

3. **Build and run the application**

Using Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or if you have Maven installed:

```bash
mvn spring-boot:run
```

The application will start and be available at http://localhost:8080

### Database Configuration

The PostgreSQL database is configured with the following settings:

- **Database Name**: runnerz
- **Username**: mohamed
- **Password**: password
- **Port**: 5432

These settings can be modified in the `compose.yaml` and `application.properties` files.

## API Endpoints

The application provides the following REST API endpoints:

| HTTP Method | Endpoint                      | Description            |
| ----------- | ----------------------------- | ---------------------- |
| GET         | /api/runs                     | Get all runs           |
| GET         | /api/runs/{id}                | Get a run by ID        |
| POST        | /api/runs                     | Create a new run       |
| PUT         | /api/runs/{id}                | Update an existing run |
| DELETE      | /api/runs/{id}                | Delete a run           |
| GET         | /api/runs/location/{location} | Get runs by location   |

### Run Object Structure

```json
{
  "id": 1,
  "title": "Morning Run",
  "startedOn": "2024-02-20T06:05:00.000000",
  "completedOn": "2024-02-20T10:27:00.000000",
  "miles": 24,
  "location": "INDOOR",
  "version": null
}
```

### API Examples

You can use the provided HTTP file (`api/runnerz.http`) or Postman collection (`api/runnerz-postman-collection.json`) to test the API endpoints.

#### Example: Creating a Run

```http
POST http://localhost:8080/api/runs
Content-Type: application/json

{
  "id": 11,
  "title": "Saturday Morning Run",
  "startedOn": "2024-02-10T15:00:12.49766",
  "completedOn": "2024-02-10T16:01:12.497678",
  "miles": 6,
  "location": "OUTDOOR"
}
```

## Data Loading

On application startup, the system will check if the database is empty and load sample run data from `src/main/resources/data/runs.json` if needed.

## External User API Integration

The application includes a client for interacting with a user API at `jsonplaceholder.typicode.com`, demonstrating how to connect to external services.

## Testing

Run the tests using the Maven wrapper:

```bash
./mvnw test
```

## License

This project is licensed under the Apache License 2.0 - see the LICENSE file for details.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request
