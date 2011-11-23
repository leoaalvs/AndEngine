package org.andengine.entity.scene.background;

import org.andengine.engine.camera.Camera;
import org.andengine.util.color.Color;
import org.andengine.util.modifier.IModifier;
import org.andengine.util.modifier.ModifierList;

import android.opengl.GLES20;


/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 14:08:17 - 19.07.2010
 */
public class Background implements IBackground {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final int BACKGROUNDMODIFIERS_CAPACITY_DEFAULT = 4;

	// ===========================================================
	// Fields
	// ===========================================================

	private final ModifierList<IBackground> mBackgroundModifiers = new ModifierList<IBackground>(this, BACKGROUNDMODIFIERS_CAPACITY_DEFAULT);
	
	private Color mColor = new Color(0, 0, 0, 1);
	private boolean mColorEnabled = true;

	// ===========================================================
	// Constructors
	// ===========================================================

	protected Background() {

	}

	public Background(final float pRed, final float pGreen, final float pBlue) {
		this.mColor.set(pRed, pGreen, pBlue);
	}

	public Background(final float pRed, final float pGreen, final float pBlue, final float pAlpha) {
		this.mColor.set(pRed, pGreen, pBlue, pAlpha);
	}

	public Background(final Color pColor) {
		this.mColor.set(pColor);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * Sets the color using the arithmetic scheme (0.0f - 1.0f RGB triple).
	 * @param pRed The red color value. Should be between 0.0 and 1.0, inclusive.
	 * @param pGreen The green color value. Should be between 0.0 and 1.0, inclusive.
	 * @param pBlue The blue color value. Should be between 0.0 and 1.0, inclusive.
	 */
	@Override
	public void setColor(final float pRed, final float pGreen, final float pBlue) {
		this.mColor.set(pRed, pGreen, pBlue);
	}

	/**
	 * Sets the color using the arithmetic scheme (0.0f - 1.0f RGB quadruple).
	 * @param pRed The red color value. Should be between 0.0 and 1.0, inclusive.
	 * @param pGreen The green color value. Should be between 0.0 and 1.0, inclusive.
	 * @param pBlue The blue color value. Should be between 0.0 and 1.0, inclusive.
	 * @param pAlpha The alpha color value. Should be between 0.0 and 1.0, inclusive.
	 */
	@Override
	public void setColor(final float pRed, final float pGreen, final float pBlue, final float pAlpha) {
		this.mColor.set(pRed, pGreen, pBlue, pAlpha);
	}
	
	@Override
	public void setColor(final Color pColor) {
		this.mColor.set(pColor);
	}

	@Override
	public boolean isColorEnabled() {
		return this.mColorEnabled;
	}

	@Override
	public void setColorEnabled(final boolean pColorEnabled) {
		this.mColorEnabled = pColorEnabled;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void addBackgroundModifier(final IModifier<IBackground> pBackgroundModifier) {
		this.mBackgroundModifiers.add(pBackgroundModifier);
	}

	@Override
	public boolean removeBackgroundModifier(final IModifier<IBackground> pBackgroundModifier) {
		return this.mBackgroundModifiers.remove(pBackgroundModifier);
	}

	@Override
	public void clearBackgroundModifiers() {
		this.mBackgroundModifiers.clear();
	}

	@Override
	public void onUpdate(final float pSecondsElapsed) {
		this.mBackgroundModifiers.onUpdate(pSecondsElapsed);
	}

	@Override
	public void onDraw(final Camera pCamera) {
		if(this.mColorEnabled) {
			GLES20.glClearColor(this.mColor.getRed(), this.mColor.getGreen(), this.mColor.getBlue(), this.mColor.getAlpha());
			GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT); // TODO See commented out code in Renderer, bc of MultiSample
		}
	}

	@Override
	public void reset() {
		this.mBackgroundModifiers.reset();
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
