describe('Login Functionality', () => {
  it('should allow a user to log in with valid credentials', () => {
    cy.visit('https://example.com/login');

    // Enter valid credentials
    cy.get('input[name="username"]').type('validUser');
    cy.get('input[name="password"]').type('validPassword');

    // Submit the login form
    cy.get('button[type="submit"]').click();

    // Verify successful login
    cy.url().should('include', '/dashboard');
    cy.get('.welcome-message').should('contain', 'Welcome validUser');
  });
});