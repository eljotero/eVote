describe('The Info page', () => {
    beforeEach(() => {
      cy.viewport(1920, 1080);
      cy.visit('/info')
    })
  
    it('successfully loads', () => {
      cy.url().should('include', '/info')
    })

    it('has info about authors', () => {
        cy.get('span').contains('Michał Ferdzyn (242383)').should('exist')
        cy.get('span').contains('Aleksander Janicki (242405)').should('exist')
        cy.get('span').contains('Grzegorz Kempa (224325)').should('exist')
        cy.get('span').contains('Szymon Wydmuch (242568)').should('exist')
        cy.get('span').contains('Michalina Wysocka (230043)').should('exist')
    })
  
    it('has info about subject', () => {
        cy.get('p').contains('Projekt stworzony w ramach przedmiotu Moduł sumatywny').should('exist')
    })

    it('has info about used pictures source', () => {
        cy.get('span').contains('Obrazy zostały pobrane ze strony Canva, utworzone przez zespół Canvy na darmowej licencji i użyte w celach niekomercyjnych.').should('exist')
    })


})