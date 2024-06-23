describe('The Main Page', () => {
  beforeEach(() => {
    cy.viewport(1920, 1080);
    cy.visit('/')
  })

  it('successfully loads', () => {
    cy.url().should('include', '/')
  })

  it('has a navigation menu', () => {
    cy.get('nav').should('exist')
  })

  it('can navigate to the Home page from the Main page', () => {
    cy.get('nav').contains('Strona główna').click({ force: true });
    cy.url().should('include', '/');
  })

  it('can navigate to the How to vote from the Main page', () => {
    cy.get('nav').contains('Jak zagłosować').click({ force: true });
    cy.url().should('include', '/about');
  })

  it('can navigate to the Candidates from the Main page', () => {
    cy.get('nav').contains('Kandydaci').click({ force: true });
    cy.url().should('include', '/map');
  })

  it('can navigate to the Info from the Main page', () => {
    cy.get('nav').contains('Informacje').click({ force: true });
    cy.url().should('include', '/info');
  })

})