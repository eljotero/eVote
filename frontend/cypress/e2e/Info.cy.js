describe('The Info page', () => {
    beforeEach(() => {
      cy.visit('/info')
    })
  
    it('successfully loads', () => {
      cy.url().should('include', '/info')
    })

    it('has info about authors', () => {
        cy.get('span').contains('Imię Nazwisko').should('exist')
    })
  
    it('has info about subject', () => {
        cy.get('p').contains('Projekt stworzony w ramach przedmiotu [nazwa]').should('exist')
    })

    it('has info about used pictures source', () => {
        cy.get('span').contains('Obrazy zostały pobrane ze strony Canva, utworzone przez zespół Canvy na darmowej licencji i użyte w celach niekomercyjnych.').should('exist')
    })


})