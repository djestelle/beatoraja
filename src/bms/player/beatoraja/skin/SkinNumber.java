package bms.player.beatoraja.skin;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * 数字オブジェクト
 * 
 * @author exch
 */
public class SkinNumber extends SkinObject {

	/**
	 * イメージ
	 */
	private TextureRegion[] image;
	
	private int id;

	private int cycle;
	
	private int keta;
	
	private int zeropadding;
	
	private TextureRegion[] values;

	public SkinNumber(TextureRegion[] image, int cycle, int keta, int zeropadding) {
		this.image = image;
		this.cycle = cycle;
		this.setKeta(keta);
		this.zeropadding = zeropadding;		
	}
	
	public TextureRegion[] getImage() {
		return image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKeta() {
		return keta;
	}

	public void setKeta(int keta) {
		this.keta = keta;
		this.values = new TextureRegion[keta];
	}
	
	public TextureRegion[] getValue(int value, int zeropadding) {
		for (int j = values.length - 1; j >= 0; j--) {
			if(value > 0 || j == values.length - 1) {
				values[j] = image[value % 10];				
			} else {
				values[j] = (zeropadding == 2 ? image[10] : (zeropadding == 1 ? image[0] : null));
			}
			value /= 10;
		}
		return values;
	}
	
	public void draw(SpriteBatch sprite, long time, int value) {
		Rectangle r = this.getDestination(time);
		TextureRegion[] values = getValue(value, zeropadding);
		for (int j = 0; j < values.length; j++) {
			if(values[j] != null) {
				sprite.draw(values[j], r.x + r.width * j, r.y, r.width, r.height);				
			}
		}


		
	}

}
