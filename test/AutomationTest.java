describe('User Login Tests', () => {
  it('should log in a user successfully', () => {
    cy.visit('/login');
    cy.get('input[name="username"]').type('testUser');
    cy.get('input[name="password"]').type('testPassword');
    cy.get('button[type="submit"]').click();
    cy.url().should('include', '/dashboard');
    cy.get('.welcome-message').should('contain', 'Welcome, testUser');
  });
});