package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  private GT4500 ship;
  TorpedoStore primary = mock(TorpedoStore.class);
  TorpedoStore secondary = mock(TorpedoStore.class);

  @Before
  public void init(){
    this.ship = new GT4500(primary, secondary);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
	 when(primary.isEmpty()).thenReturn(false);
	 when(primary.fire(1)).thenReturn(true);
	 
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }
 
  @Test
  public void fireTorpedo_Twice_Success(){
	  //Arrange	  
	  ship.fireLaser(FiringMode.SINGLE);
	  
	  //Act
	  boolean result = ship.fireTorpedo(FiringMode.SINGLE);
	  
	  // Assert
	  assertEquals(true, result);
  }

  
  
}
