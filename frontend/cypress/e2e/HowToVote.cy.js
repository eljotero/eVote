describe('The Main Page', () => {
    beforeEach(() => {
      cy.visit('/about')
      cy.viewport(1920, 1080);
    })

  
    it('successfully loads', () => {
      cy.url().should('include', '/about')
    })

    it('has first step', () => {
        cy.get('p').contains('Aby rozpocząć, załóż konto na naszej platformie. Kliknij przycisk "Zaloguj się", a następnie "Rejestracja" i podaj swój adres e-mail oraz hasło.').should('exist')
      })
  
    it('has second step', () => {
      cy.get('p').contains('Po zalogowaniu się, wejdź w zakładkę "Moje konto" i wypełnij dodatkowe informacje potrzebne do weryfikacji tożsamości. Wprowadź swoje dane osobowe, takie jak PESEL czy adres zamieszkania. Wszystkie dane są zabezpieczone i przetwarzane zgodnie z przepisami o ochronie danych osobowych.').should('exist')
    })

    it('has third step', () => {
        cy.get('p').contains('Następnie przejdź do sekcji "Kandydaci". Tam znajdziesz listę dostępnych wyborów oraz kandydatów. Możesz przeglądać profile kandydatów, czytać ich programy wyborcze i zapoznać się z ich priorytetami.').should('exist')
    })
  
    it('has forth step', () => {
        cy.get('p').contains('Gdy już zdecydujesz, na kogo chcesz oddać głos, w sekcji "Moje konto" wygeneruj kod umożliwiający zagłosowanie. Po otrzymaniu go na podany adres e-mail, przejdź do sekcji "Zagłosuj" i wpisz kod. Twój głos na wybranego kandydata zostanie zarejestrowany i możesz być pewny, że jest bezpieczny i anonimowy.').should('exist')
    })

})