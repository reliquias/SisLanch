package br.com.reliquias.SisLanch.util;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package br.com.reliquias.SisLanch.dao.util;
//
//import br.com.reliquias.SisLanch.modelo.Cidade;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.FacesConverter;
//
///**
// *
// * @author java1
// */
//@FacesConverter(value="cidadeConverter", forClass=Cidade.class)
//public class CidadeConverter implements Converter {
//private Cidade cidade = new Cidade();
//
//   @Override
//    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//        Integer code = Integer.parseInt(value);
//        try {
//            return cidade.getId(code);
//        } catch (Exception ex) {
//            Logger.getLogger(CidadeConverter.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//
//    @Override
//       public String getAsString (FacesContext context, UIComponent component, Object value) {
//        Cidade cid = (Cidade) value;
//        return String.valueOf(prod.getCode());
//    }
//
//
//}
