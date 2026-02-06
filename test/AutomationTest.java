describe('User Login Test', () => {
  it('should log in successfully with valid credentials', () => {
    // Visit the login page
    cy.visit('https://example.com/login');

    // Enter username
    cy.get('#username').type('validUsername');

    // Enter password
    cy.get('#password').type('validPassword');

    // Click the login button
    cy.get('#loginButton').click();

    // Verify successful login by checking the URL or a specific element
    cy.url().should('include', '/dashboard');
    cy.get('.welcome-message').should('contain', 'Welcome, validUsername');
  });
});