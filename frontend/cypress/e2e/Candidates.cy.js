describe('User can look through candidates', () => {
    beforeEach(() => {
        cy.viewport(1920, 1080);
      });

    it('successfully check candidates in selected ', () => {
        cy.visit('/candidates?woj=%C5%81%C3%B3dzkie');
      
        cy.get('#district-select').should('exist');
        cy.get('#district-select2').should('exist');

        cy.get('#district-select').select('Okręg wyborczy nr 10 - Piotrków Trybunalskich');
        cy.get('#district-select2').select('Okręg wyborczy nr 24 - Łódź II');

        cy.get('#district-select').select('Okręg wyborczy nr 9 - Łódź');
        cy.get('#district-select2').select('Okręg wyborczy nr 23 - Łódź I');

        cy.get('#showPlanButton').click({force: true});
        cy.get('h2').should('contain.text', 'Krótki plan polityczny');
        cy.get('#closePlanButton').click({force: true});
    });

  });
