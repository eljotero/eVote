# eVote
The eVote system is an advanced election management system designed to comprehensively organize and conduct various types of elections. The system is designed to be easy to use, secure, and flexible, meeting the needs of state institutions.

## Features of the eVote System

### 1. Creating and Managing Elections
The eVote system allows for easy creation of new elections. Administrators can specify details such as:
- Name and description of the election.
- Start and end date of voting.
- Type of election (e.g., presidential elections, referendums, council elections, etc.).

### 2. Adding Candidates
eVote enables adding candidates to individual elections. Administrators can:
- Enter candidate data, such as first name, last name, photo, and a brief description.
- Organize candidates into different categories or political parties.
- Update or delete candidate information as needed.

### 3. Voting
The eVote system ensures secure and anonymous voting. Voting features include:
- A user interface allowing the selection of preferred candidates.
- Ensuring that each user can cast only one vote.
- The ability to verify voters' identities using unique identifiers or JWT tokens.

### 4. Authentication and Security
Security is a key aspect of the eVote system. Security-related features include:
- JWT-based authentication, ensuring secure login and session management.
- Encryption of data stored in the database and transmitted between the frontend and backend.
- User roles, allowing different levels of access (e.g., administrators, users).

### 5. Election Results
eVote enables fast and accurate vote counting and presenting results. These features include:
- Displaying live results during the voting process.
- Generating reports with results after the election ends.
- Exporting results to various formats (e.g., CSV, PDF).

### 6. User Management
The system offers advanced user management tools, including:
- Registration of new users.
- Managing user data, including editing and deleting accounts.
- Assigning roles and permissions to individual users.

The eVote system offers all these functionalities to create a secure, efficient, and user-friendly election management tool that can be tailored to different needs and election scenarios.

## Frontend
The eVote application's frontend is built using [Next.js](https://nextjs.org/), a framework based on [React](https://reactjs.org/). We use [Tailwind CSS](https://tailwindcss.com/) for styling, configured in the [tailwind.config.js](frontend/tailwind.config.js) file.

The frontend uses [axios](https://axios-http.com/) for making HTTP requests to the backend. We use [Redux Toolkit](https://redux-toolkit.js.org/) for state management.

#### Project Structure
The project consists of several modules:
- **src/app/components:** Contains reusable React components.
- **src/store:** Contains Redux actions and reducers.
- **src/services:** Contains services for communication with the backend.
- **tests:** Contains all unit and integration tests for the frontend. Tests are written using the Jest library. 

#### Running the Project
To run the frontend, you need to have [Node.js](https://nodejs.org/) and [npm](https://www.npmjs.com/) installed. Then, execute the following commands in the frontend directory:
```sh
npm install
npm run dev
```
Open http://localhost:3000 in your browser to see the result.

#### Tests
To run tests for the frontend, execute the following commands in the frontend directory:
```
npm test
```
Tests are run using [Jest](https://jestjs.io). You can also run tests in watch mode using
```
npm run test:watch
```
or generate a coverage report using
```
npm run test:coverage
```

#### Linting
The project uses [ESLint](https://eslint.org) to maintain code quality. You can run the linter using 
```
npm run lint.
```

## Backend
The backend is built using [Spring Boot](https://spring.io/projects/spring-boot), a framework for Java applications. We use [JUnit](https://junit.org/junit5/) for unit testing and,  [RestAssured](https://rest-assured.io) for integration testing. We use [Maven](https://maven.apache.org) for dependency management.

#### Project Structure
The project consists of several modules: 
- **org.evote.backend:** The main application module, contains the BackendApplication class that runs the application.
- **org.evote.backend.services:** Contains services that implement the business logic of the application.
- **org.evote.backend.controllers:** Contains controllers that handle HTTP requests.
- **org.evote.backend.users:** Contains DTOs and entities related to users.
- **org.evote.backend.votes:** Contains DTOs and entities related to voting.
- **org.evote.backend.exception:** Contains exceptions and global handler.
- **org.evote.backend.unit:** Contains unit tests.
- **org.evote.backend.integration:** Contains integration tests.

#### Running the Project
To run the backend, you need to have [Java](https://www.oracle.com/java/technologies/downloads/) and [Maven](https://maven.apache.org) installed. Then, execute the following commands in the root directory of the project:
```sh
mvn clean install
mvn spring-boot:run
```
The application will be available at http://localhost:8080.

#### Tests
To run tests for the backend, execute the following commands in the root directory of the project:
```
mvn test
```

#### Authentication
The project uses JWT-based authentication. The token is generated upon successful login and must be included in the Authorization header with each request.

#### Database
The project uses a PostgreSQL database, which is run using Docker. By default, data is stored on disk and not deleted after the session ends. The database and Docker configuration is located in the  [docker-compose.yml](docker/compose.yml) and [application.properties](backend/src/main/resources/application.properties) files.

## CI/CD
The project uses GitHub Actions for automatic building and testing of the code. See the [maven.yml](.github/workflows/maven.yml) file for details.
