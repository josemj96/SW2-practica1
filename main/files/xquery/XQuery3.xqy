for $x in doc("main/files/xml/marca.xml")/marca/productos/productos
return if ($x/@fechaDePublicacion="26-10-1998")
then <fechaIdentica>{data($x/nombre)}</fechaIdentica>
else <fechaDiferente>{data($x/nombre)}</fechaDiferente>