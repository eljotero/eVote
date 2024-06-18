describe('User Register and Login E2E Tests', () => {
    beforeEach(() => {
        cy.visit('/login');
        cy.url().should('include', '/login');
        cy.get('#email').type('test1234@test.com');
        cy.get('#password').type('test1234');
        cy.get('button').contains('Zaloguj').click({ force: true });
        cy.get('nav').contains('Moje konto').click({ force: true });
    })

    it ('contains all fields', () => {
        cy.get('#email').should('exist');
        cy.get('#name').should('exist');
        cy.get('#surname').should('exist');
        cy.get('#sex').should('exist');
        cy.get('#birthDate').should('exist');
        cy.get('#education').should('exist');
        cy.get('#profession').should('exist');
        cy.get('#personalIdNumber').should('exist');
        cy.get('#zipCode').should('exist');
        cy.get('#addressLine').should('exist');
        cy.get('#city').should('exist');
        cy.get('#cityType').should('exist');
        cy.get('#country').should('exist');
        cy.get('#voivodeship').should('exist');
    })

    it ('can type into inputs', () => {
        cy.get('#name').type('IMIE');
        cy.get('#surname').type('NAZWISKO');
        cy.get('#sex').select('Mężczyzna');
        cy.get('#birthDate').type('1999-01-01');
        cy.get('#education').select('Wyższe');
        cy.get('#profession').type('ZAWÓD');
        cy.get('#personalIdNumber').type(12345578911);
        cy.get('#zipCode').type('90-001');
        cy.get('#addressLine').type('Politechniki 21/37');
        cy.get('#city').type('Łódź');
        cy.get('#cityType').select('Pomiędzy 200 a 500 tysięcy');
        cy.get('#country').select('Poland');
        cy.get('#voivodeship').select('Łódzkie');
    })

    it ('can save inputs values', () => {
        cy.get('#name').clear();
        cy.get('#name').type('IMIE');

        cy.get('#surname').clear();
        cy.get('#surname').type('NAZWISKO');

        cy.get('#sex').select('Mężczyzna');

        cy.get('#birthDate').clear();
        cy.get('#birthDate').type('1999-01-01');

        cy.get('#education').select('Wyższe');

        cy.get('#profession').clear();
        cy.get('#profession').type('ZAWÓD');

        cy.get('#personalIdNumber').clear();
        cy.get('#personalIdNumber').type(12345578911);

        cy.get('#zipCode').clear();
        cy.get('#zipCode').type('90-001');

        cy.get('#addressLine').clear();
        cy.get('#addressLine').type('Politechniki 21/37');

        cy.get('#city').clear();
        cy.get('#city').type('Łódź');

        cy.get('#cityType').select('Pomiędzy 200 a 500 tysięcy');
        cy.get('#country').select('Poland');
        cy.get('#voivodeship').select('Łódzkie');

        cy.get('button').contains('Zapisz').click({ force: true });

        cy.get('nav').contains('Strona główna').click({ force: true });
        cy.get('nav').contains('Moje konto').click({ force: true });

        cy.get('#name').should('have.value', 'IMIE');
        cy.get('#surname').should('have.value', 'NAZWISKO');
        cy.get('#birthDate').should('have.value', '1999-01-01');
        cy.get('#profession').should('have.value', 'ZAWÓD');
        cy.get('#zipCode').should('have.value', '90-001');
        cy.get('#addressLine').should('have.value', 'Politechniki 21/37');
        cy.get('#city').should('have.value', 'Łódź');
    })

    it ('can logout', () => {
        cy.get('nav').contains('Wyloguj').click({ force: true });
        cy.url().should('include', '/');
    })

  });