<ul>
{
for $x in doc("main/files/xml/marca.xml")/marca/productos/productos/nombre
order by $x
return <li>{$x}</li>
}
</ul>