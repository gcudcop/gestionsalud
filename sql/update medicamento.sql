CREATE OR REPLACE FUNCTION subcentro_licto.f_update_medicamento (pcodigo_medicamento character varying,pnombre_medicamento character varying,pforma_farmaceutica character varying,pconcentracion character varying)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
UPDATE subcentro.medicamento SET codigo_medicamento=$1,nombre_medicamento=$2,forma_farmaceutica=$3,concentracion=$4
WHERE id_mediamento=$4;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;