describe('User Register and Login E2E Tests', () => {
    beforeEach(() => {
      cy.viewport(1920, 1080);
    });

    it('successfully register and login in the user', () => {
      cy.visit('/login');
      cy.url().should('include', '/login');
      
      cy.get('.changeFormButton').contains('Rejestracja').click({ force: true });
      cy.get('#email').type('test1234@test.com');
      cy.get('#password').type('test1234');
      cy.get('#confirmPassword').type('test1234');
      cy.get('button').contains('Zarejestruj się').click({ force: true });

      cy.url().should('include', '/');
    });
  });

