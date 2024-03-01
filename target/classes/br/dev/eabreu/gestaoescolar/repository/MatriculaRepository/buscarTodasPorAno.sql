SELECT
	m.*
FROM TbMatricula m
INNER JOIN TbTurma t ON t.codigo = m.codigoTurma
WHERE t.ano = :ano