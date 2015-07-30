CREATE OR REPLACE FUNCTION subcentro_licto.f_insert_medicamento(pnombre_medicamento character varying,pforma_farmaceutica character varying, pconcentracion character varying)
RETURNS boolean AS
$BODY$declare band boolean;
begin
INSERT INTO subcentro_licto.f_insert_medicamento(pnombre_medicamento,pforma_farmaceutica,pconcentracion) VALUES ($1,$2,$3);
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;