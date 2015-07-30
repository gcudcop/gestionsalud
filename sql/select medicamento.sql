CREATE OR REPLACE FUNCTION subcentro_licto.f_select_medicamento(OUT codigo_medicamento character varying,OUT nombre_medicamento character varying,OUT forma_farmaceutica character varying,OUT concentracion character varying)  RETURNS SETOF record AS
$BODY$
begin
return QUERY SELECT  id_medicamento,codigo_medicamento,nombre_medicamento,forma_farmaceutica,concentracion
from subcentro_licto.medicamento;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;