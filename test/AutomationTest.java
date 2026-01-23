describe('Login Test', () => {
  it('should log in successfully', () => {
    cy.visit('/login');
    cy.get('#username').type('testuser');
    cy.get('#password').type('password123');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });
});