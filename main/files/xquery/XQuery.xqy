for $x in
doc("main/files/xml/marca.xml")/marca/productos/productos
where $x/tipo="Complemento"
order by $x/nombre
return $x