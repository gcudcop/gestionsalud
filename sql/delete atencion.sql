CREATE OR REPLACE FUNCTION subcentro_licto.f_delete_atencion(pid_atencion bigint)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
DELETE FROM subcentro_licto.atencion WHERE id_atencion=$1;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;