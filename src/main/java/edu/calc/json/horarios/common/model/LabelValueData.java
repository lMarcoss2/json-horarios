package edu.calc.json.horarios.common.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
public class LabelValueData {

  private String label;
  private String value;


  public static LabelValueData mapperLavelValue(ResultSet rs) throws SQLException{
    LabelValueData labelValueData = new LabelValueData();
    labelValueData.setValue(rs.getString(1));
    labelValueData.setLabel(rs.getString(2));

    return labelValueData;
  }
}
