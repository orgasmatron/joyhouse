/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractProduct;

import java.math.BigDecimal;

/**
 *
 * @author AlshevskiYV
 */
public interface Product {
   public Integer getId();
   public BigDecimal getPrice();
   public String getName();
}
