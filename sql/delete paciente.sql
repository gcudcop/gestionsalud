CREATE OR REPLACE FUNCTION subcentro_licto.f_delete_paciente(pid_paciente bigint)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
DELETE FROM subcentro_licto.paciente WHERE id_paciente=$1;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100