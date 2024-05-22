# eVote
System eVote to zaawansowany system zarządzania wyborami, który umożliwia kompleksową organizację i przeprowadzanie różnych typów wyborów. System jest zaprojektowany tak, aby był łatwy w użyciu, bezpieczny i elastyczny, spełniając potrzeby instytucji państwowych. 

## Funkcjonalności systemu eVote

### 1. Tworzenie i zarządzanie wyborami
System eVote pozwala na łatwe tworzenie nowych wyborów. Administratorzy mogą określić szczegóły takie jak:
- Nazwa i opis wyborów.
- Data rozpoczęcia i zakończenia głosowania.
- Typ wyborów (np. wybory prezydenckie, referenda, wybory do rady itp.).

### 2. Dodawanie kandydatów
eVote umożliwia dodawanie kandydatów do poszczególnych wyborów. Administratorzy mogą:
- Wprowadzać dane kandydatów, takie jak imię, nazwisko, zdjęcie i krótki opis.
- Organizować kandydatów w różnych kategoriach lub partiach politycznych.
- Aktualizować lub usuwać informacje o kandydacie w razie potrzeby.

### 3. Głosowanie
System eVote zapewnia bezpieczne i anonimowe oddawanie głosów. Funkcje głosowania obejmują:
- Interfejs użytkownika umożliwiający wybór preferowanych kandydatów.
- Zapewnienie, że każdy użytkownik może oddać tylko jeden głos.
- Możliwość weryfikacji tożsamości głosujących przy użyciu unikalnych identyfikatorów lub tokenów JWT.

### 4. Autentykacja i bezpieczeństwo
Bezpieczeństwo jest kluczowym aspektem systemu eVote. Funkcje związane z bezpieczeństwem obejmują:
- Autentykację opartą na tokenach JWT, która zapewnia bezpieczne logowanie i zarządzanie sesjami.
- Szyfrowanie danych przechowywanych w bazie danych oraz przesyłanych między frontendem a backendem.
- Role użytkowników, umożliwiające różne poziomy dostępu (np. administratorzy, użytkownicy).

### 5. Wyniki wyborów
eVote umożliwia szybkie i dokładne przeliczanie głosów oraz prezentowanie wyników. Funkcje te obejmują:
- Wyświetlanie wyników na żywo w trakcie trwania głosowania.
- Generowanie raportów z wynikami po zakończeniu wyborów.
- Możliwość eksportu wyników do różnych formatów (np. CSV, PDF).

### 6. Zarządzanie użytkownikami
System oferuje zaawansowane narzędzia do zarządzania użytkownikami, w tym:
- Rejestrację nowych użytkowników.
- Zarządzanie danymi użytkowników, w tym edycję i usuwanie kont.
- Przydzielanie ról i uprawnień poszczególnym użytkownikom.

System eVote oferuje wszystkie te funkcjonalności w celu stworzenia bezpiecznego, efektywnego i łatwego w użyciu narzędzia do zarządzania wyborami, które może być dostosowane do różnych potrzeb i scenariuszy wyborczych.

## Frontend
Frontend aplikacji eVote został zbudowany przy użyciu [Next.js](https://nextjs.org/), frameworka opartego na [React](https://reactjs.org/). Do stylizacji używamy [Tailwind CSS](https://tailwindcss.com/) którego konfiguracja jest w pliku [tailwind.config.js](frontend/tailwind.config.js).

Frontend korzysta z [axios](https://axios-http.com/) do wykonywania żądań HTTP do backendu. Do zarządzania stanem aplikacji używamy [Redux Toolkit](https://redux-toolkit.js.org/).

#### Struktura projektu
Projekt składa się z kilku modułów:
- **src/app/components:** Zawiera reużywalne komponenty React.
- **src/store:** Zawiera akcje i reducery Redux.
- **src/services:** Zawiera serwisy do komunikacji z backendem.
- **tests:** Zawiera wszystkie testy jednostkowe i integracyjne dla frontendu. Testy są pisane za pomocą biblioteki Jest. 

#### Uruchomienie projektu
Aby uruchomić frontend, musisz mieć zainstalowany [Node.js](https://nodejs.org/) i [npm](https://www.npmjs.com/). Następnie wykonaj następujące polecenia w katalogu frontend:
```sh
npm install
npm run dev
```
Otwórz http://localhost:3000 w przeglądarce, aby zobaczyć wynik.

#### Testy
Aby uruchomić testy dla frontendu, wykonaj następujące polecenia w katalogu frontend:
```
npm test
```
Testy są wykonywane przy użyciu [Jest](https://jestjs.io). Możesz również uruchomić testy w trybie watch za pomocą 
```
npm run test:watch
```
lub wygenerować raport pokrycia testami za pomocą 
```
npm run test:coverage
```

#### Linting
Projekt korzysta z [ESLint](https://eslint.org) do utrzymania jakości kodu. Możesz uruchomić linter za pomocą 
```
npm run lint.
```

## Backend
Backend został zbudowany przy użyciu [Spring Boot](https://spring.io/projects/spring-boot), frameworka dla aplikacji Java. 
Do testów jednostkowych używamy [JUnit](https://junit.org/junit5/), a do testów integracyjnych [RestAssured](https://rest-assured.io). 
Do zarządzania zależnościami używamy [Maven](https://maven.apache.org).

#### Struktura projektu
Projekt składa się z kilku modułów:  
- **org.evote.backend:** Główny moduł aplikacji, zawiera klasę BackendApplication uruchamiającą aplikację.
- **org.evote.backend.services:** Zawiera serwisy, które implementują logikę biznesową aplikacji.
- **org.evote.backend.controllers:** Zawiera kontrolery, które obsługują żądania HTTP.
- **org.evote.backend.users:** Zawiera klasy DTO i encje związane z użytkownikami.
- **org.evote.backend.votes:** Zawiera klasy DTO i encje związane z głosowaniem.
- **org.evote.backend.exception:**
- **org.evote.backend.unit:** Zawiera testy jednostkowe.
- **org.evote.backend.integration:** Zawiera testy integracyjne

#### Uruchomienie projektu
Aby uruchomić backend, musisz mieć zainstalowane [Java](https://www.oracle.com/java/technologies/downloads/) i [Maven](https://maven.apache.org). Następnie wykonaj następujące polecenia w katalogu głównym projektu:
```sh
mvn clean install
mvn spring-boot:run
```
Aplikacja będzie dostępna pod adresem http://localhost:8080.

#### Testy
Aby uruchomić testy dla backendu, wykonaj następujące polecenia w katalogu głównym projektu:
```
mvn test
```

#### Autentykacja
Projekt korzysta z autentykacji opartej na tokenach JWT. Token jest generowany po pomyślnym zalogowaniu i musi być przekazywany w nagłówku Authorization przy każdym żądaniu.

#### Baza danych
Projekt korzysta z bazy danych PostgreSQL, która jest uruchamiana za pomocą Dockera. Domyślnie, dane są przechowywane na dysku i nie są usuwane po zakończeniu sesji. 
Konfiguracja bazy danych oraz Dockera znajduje się w pliku [docker-compose.yml](docker/compose.yml) oraz [application.properties](backend/src/main/resources/application.properties)

## CI/CD
Projekt korzysta z GitHub Actions do automatycznego budowania i testowania kodu. Zobacz plik [maven.yml](.github/workflows/maven.yml) dla szczegółów.
