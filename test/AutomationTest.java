describe('User Login Tests', () => {
  it('should log in with valid credentials', () => {
    cy.visit('/login');
    cy.get('input[name="username"]').type('testuser');
    cy.get('input[name="password"]').type('password123');
    cy.get('button[type="submit"]').click();
    cy.url().should('include', '/dashboard');
    cy.get('.welcome-message').should('contain', 'Welcome, testuser');
  });
});