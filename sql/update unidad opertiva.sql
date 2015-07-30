CREATE OR REPLACE FUNCTION subcentro_licto.f_update_unidad_operativa(pnombre_uo character varying,pprovincia character varying,pcanton character varying,pparroquia character varying,pzona character varying,pdistrito character varying,pcircuito character varying,ptipo_uo character varying,pinstitucion_sistema integer)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
UPDATE subcentro.unidad_operativa SET nombre_uo=$1,provincia=$2,canton=$3,parroquia=$4,zona=$5,distrito=$6,circuito=$7,tipo_uo=$8,institucion_sistema=$9
WHERE id_uo=$9;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
