const { Builder, By, Key, until } = require('selenium-webdriver');

async function loginToFlipkart() {
    let driver = await new Builder().forBrowser('chrome').build();
    try {
        await driver.get('https://www.flipkart.com');
        await driver.wait(until.elementLocated(By.css('input._2IX_2-')), 10000);
        let usernameField = await driver.findElement(By.css('input._2IX_2-'));
        let passwordField = await driver.findElement(By.css('input._3mctLh'));
        let loginButton = await driver.findElement(By.css('button._2KpZ6l'));
        await usernameField.sendKeys('your-username');
        await passwordField.sendKeys('your-password');
        await loginButton.click();
        await driver.wait(until.titleIs('Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!'), 10000);
    } finally {
        await driver.quit();
    }
}

loginToFlipkart();