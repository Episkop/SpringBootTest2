<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Boot</title>
</head>
<body>
<h1>Список Аппаратов</h1>
<form action="/" method="get">
    Поиск по имени: <input type="text" name="name"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list products as product>
    <div>
        <p>
           Выключатель Автоматический серии <b>${product.name}</b>  (${product.prise}) гривен | <a href="/product/${product.id}">Информация</a>
        </p>
    </div>
    <#else >
    <h3>Автоматические выключатели отсутствуют</h3>
</#list>
<h3>Создать товара</h3>
<FORM action="/new" method="post" object="product" enctype="multipart/form-data">
    Название <input type="text" name="name"/><br><br>
    Цена <input type="number" name="prise"/><br><br>
    Город <input type="text" name="city"/><br><br>
    Количество <input type="number" name="items"/><br><br>
    Первая Фотография <input type="file" name="file1"/><br><br>
    Вторая Фотография <input type="file" name="file2"/><br><br>
    Трутья Фотография <input type="file" name="file3"/><br><br>
    <input type="submit" value="Создать"/>

</FORM>
</body>
</html>