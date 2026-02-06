describe('Login Test Suite', () => {
  it('should validate login functionality', () => {
    cy.visit('/login');
    cy.get('#username').type('testUser');
    cy.get('#password').type('testPass');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });
});