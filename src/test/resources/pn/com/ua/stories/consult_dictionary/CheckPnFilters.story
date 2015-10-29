Meta:

Narrative:
As a user
I want filter search results
So that I can find corresponding goods faster

Scenario: Check the filter by price
Given site pn.com.ua opened
When I select category Компьютеры
And I select subcategory Мониторы
And I select minimal price 6000
And I select maximal price 7000
Then search result prices is between 6000 and 7000

Scenario: Check the filter by name of the manufacturer
Given site pn.com.ua opened
When I select category Компьютеры
And I select subcategory Мониторы
And I select manufacturer Acer
Then search result amount is equal to number beside manufacturer
And search result names start with selected manufacturer Acer

Scenario: Check the product name search
Given site pn.com.ua opened
When I select category Компьютеры
And I select subcategory Мониторы
And I sort products by price
And I choose the first product in result
And I type product name to search
Then search result amount equals to 1
And search result name is equal to product name
