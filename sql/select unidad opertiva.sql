CREATE OR REPLACE FUNCTION subcentro_licto.f_select_unidad_operativa(OUT nombre_uo character varying,OUT provincia character varying,OUT canton character varying,OUT parroquia character varying,OUT zona character varying,OUT distrito character varying,OUT circuito character varying,OUT tipo_uo character varying,OUT institucion_sistema integer)  
RETURNS SETOF record AS
$BODY$
begin
return QUERY SELECT  id_uo serial,nombre_uo,provincia,canton,parroquia,zona,distrito,circuito,tipo_uo,institucion_sistema
from subcentro_licto.unidad_operativa;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
