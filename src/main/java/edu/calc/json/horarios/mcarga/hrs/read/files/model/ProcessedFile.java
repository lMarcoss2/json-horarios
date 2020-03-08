package edu.calc.json.horarios.mcarga.hrs.read.files.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Marcos Santiago Leonardo
 * Universidad de la Sierra Sur (UNSIS)
 * Description: Respuesta del servicio de carga de archivos
 * Date: 5/4/19
 */
@Builder
@Getter
@Setter
@ApiModel(description = "Entidad con los datos de carga de archivos")
public class ProcessedFile {
    @ApiModelProperty("Identificador del archivo")
    private int idFile;
    @ApiModelProperty("Error generado al procesar el archivo")
    private boolean error;
    @ApiModelProperty("Archivo cargado")
    private String file;
    @ApiModelProperty("Mensaje")
    private String message;

}
