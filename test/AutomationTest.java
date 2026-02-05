from playwright.sync_api import sync_playwright

class LoginPage:
    def __init__(self, page):
        self.page = page
        self.username_input = self.page.locator('input[name="username"]')
        self.password_input = self.page.locator('input[name="password"]')
        self.login_button = self.page.locator('button[type="submit"]')

    def login(self, username, password):
        self.username_input.fill(username)
        self.password_input.fill(password)
        self.login_button.click()


def run_login_test():
    with sync_playwright() as p:
        browser = p.chromium.launch()
        page = browser.new_page()
        login_page = LoginPage(page)
        page.goto('https://example.com/login')
        login_page.login('testuser', 'testpass')
        assert page.url == 'https://example.com/dashboard'
        browser.close()

if __name__ == '__main__':
    run_login_test()