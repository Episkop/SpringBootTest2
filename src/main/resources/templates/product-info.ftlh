<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Информация</title>
</head>
<body>
<h1>Подробная информация</h1>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название товара:</b> ${product.name}<br>
<b>Цена товара:</b> ${product.prise}<br>
<b>Местоположение товара:</b> ${product.city}<br>
<b>Количество:</b> ${product.items}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить">
    <input type="button" onclick="history.back();" value="Назад"/>
</form>
</body>
</html>