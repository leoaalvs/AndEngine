package org.andengine.entity;

import java.util.Comparator;

import org.andengine.engine.Engine;
import org.andengine.engine.handler.IDrawHandler;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.runnable.RunnableHandler;
import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierMatcher;
import org.andengine.entity.scene.Scene;
import org.andengine.util.IMatcher;
import org.andengine.util.ParameterCallable;
import org.andengine.util.color.Color;
import org.andengine.util.transformation.Transformation;


/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 11:20:25 - 08.03.2010
 */
public interface IEntity extends IDrawHandler, IUpdateHandler {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public boolean isVisible();
	public void setVisible(final boolean pVisible);

	public boolean isIgnoreUpdate();
	public void setIgnoreUpdate(boolean pIgnoreUpdate);

	public boolean isChildrenVisible();
	public void setChildrenVisible(final boolean pChildrenVisible);

	public boolean isChildrenIgnoreUpdate();
	public void setChildrenIgnoreUpdate(boolean pChildrenIgnoreUpdate);

	public int getZIndex();
	public void setZIndex(final int pZIndex);

	public boolean hasParent();
	public IEntity getParent();
	public void setParent(final IEntity pEntity);

	public float getX();
	public float getY();

	public float getInitialX();
	public float getInitialY();

	public void setInitialPosition();
	public void setPosition(final IEntity pOtherEntity);
	public void setPosition(final float pX, final float pY);

	public boolean isRotated();
	public float getRotation();
	public void setRotation(final float pRotation);

	public float getRotationCenterX();
	public float getRotationCenterY();
	public void setRotationCenterX(final float pRotationCenterX);
	public void setRotationCenterY(final float pRotationCenterY);
	public void setRotationCenter(final float pRotationCenterX, final float pRotationCenterY);

	public boolean isScaled();
	public float getScaleX();
	public float getScaleY();
	public void setScaleX(final float pScaleX);
	public void setScaleY(final float pScaleY);
	public void setScale(final float pScale);
	public void setScale(final float pScaleX, final float pScaleY);

	public float getScaleCenterX();
	public float getScaleCenterY();
	public void setScaleCenterX(final float pScaleCenterX);
	public void setScaleCenterY(final float pScaleCenterY);
	public void setScaleCenter(final float pScaleCenterX, final float pScaleCenterY);

	public boolean isSkewed();
	public float getSkewX();
	public float getSkewY();
	public void setSkewX(final float pSkewX);
	public void setSkewY(final float pSkewY);
	public void setSkew(final float pSkew);
	public void setSkew(final float pSkewX, final float pSkewY);

	public float getSkewCenterX();
	public float getSkewCenterY();
	public void setSkewCenterX(final float pSkewCenterX);
	public void setSkewCenterY(final float pSkewCenterY);
	public void setSkewCenter(final float pSkewCenterX, final float pSkewCenterY);

	public boolean isRotatedOrScaledOrSkewed();

	public float getRed();
	public float getGreen();
	public float getBlue();
	public float getAlpha();
	public Color getColor();

	public void setAlpha(final float pAlpha);
	public void setColor(final Color pColor);
	public void setColor(final float pRed, final float pGreen, final float pBlue);
	public void setColor(final float pRed, final float pGreen, final float pBlue, final float pAlpha);

	/**
	 * @return a shared(!) float[] of length 2.
	 */
	public float[] getSceneCenterCoordinates();

	/**
	 * @param pX
	 * @param pY
	 * @return a shared(!) float[] of length 2.
	 */
	public float[] convertLocalToSceneCoordinates(final float pX, final float pY);
	/**
	 * @param pX
	 * @param pY
	 * @param pReuse must be of length 2.
	 * @return <code>pReuse</code> as a convenience.
	 */
	public float[] convertLocalToSceneCoordinates(final float pX, final float pY, final float[] pReuse);
	/**
	 * @param pCoordinates must be of length 2.
	 * @return a shared(!) float[] of length 2.
	 */
	public float[] convertLocalToSceneCoordinates(final float[] pCoordinates);
	/**
	 * @param pCoordinates must be of length 2.
	 * @param pReuse must be of length 2.
	 * @return <code>pReuse</code> as a convenience.
	 */
	public float[] convertLocalToSceneCoordinates(final float[] pCoordinates, final float[] pReuse);

	/**
	 * @param pX
	 * @param pY
	 * @return a shared(!) float[] of length 2.
	 */
	public float[] convertSceneToLocalCoordinates(final float pX, final float pY);
	/**
	 * @param pX
	 * @param pY
	 * @param pReuse must be of length 2.
	 * @return <code>pReuse</code> as a convenience.
	 */
	public float[] convertSceneToLocalCoordinates(final float pX, final float pY, final float[] pReuse);
	/**
	 * @param pCoordinates must be of length 2.
	 * @return a shared(!) float[] of length 2.
	 */
	public float[] convertSceneToLocalCoordinates(final float[] pCoordinates);
	/**
	 * @param pCoordinates must be of length 2.
	 * @param pReuse must be of length 2.
	 * @return <code>pReuse</code> as a convenience.
	 */
	public float[] convertSceneToLocalCoordinates(final float[] pCoordinates, final float[] pReuse);

	public Transformation getLocalToSceneTransformation();
	public Transformation getSceneToLocalTransformation();

	//	public Transformation getLocalToParentTransformation(); // TODO Add this method.
	//	public Transformation getParentToLocalTransformation(); // TODO Add this method.

	public int getChildCount();

	public void onAttached();
	public void onDetached();

	public void attachChild(final IEntity pEntity);
	public boolean attachChild(final IEntity pEntity, final int pIndex);

	public IEntity getChild(final int pIndex);
	public IEntity getFirstChild();
	public IEntity getLastChild();
	public int getChildIndex(final IEntity pEntity);
	public boolean setChildIndex(final IEntity pEntity, final int pIndex);

	public IEntity findChild(final IEntityMatcher pEntityMatcher);

	public boolean swapChildren(final int pIndexA, final int pIndexB);
	public boolean swapChildren(final IEntity pEntityA, final IEntity pEntityB);

	/**
	 * Immediately sorts the {@link IEntity}s based on their ZIndex. Sort is stable.
	 */
	public void sortChildren();
	/**
	 * Sorts the {@link IEntity}s based on their ZIndex. Sort is stable.
	 * In contrast to {@link IEntity#sortChildren()} this method is particularly useful to avoid multiple sorts per frame. 
	 * @param pImmediate if <code>true</code>, the sorting is executed immediately.
	 * If <code>false</code> the sorting is executed before the next (visible) drawing of the children of this {@link IEntity}. 
	 */
	public void sortChildren(final boolean pImmediate);
	/**
	 * Sorts the {@link IEntity}s based on the {@link Comparator} supplied. Sort is stable.
	 * @param pEntityComparator
	 */
	public void sortChildren(final Comparator<IEntity> pEntityComparator);

	public boolean detachSelf();

	/**
	 * <b><i>WARNING:</i> This function should be called from within
	 * {@link RunnableHandler#postRunnable(Runnable)} which is registered
	 * to a {@link Scene} or the {@link Engine} itself, because otherwise
	 * it may throw an {@link IndexOutOfBoundsException} in the
	 * Update-Thread or the GL-Thread!</b>
	 */
	public boolean detachChild(final IEntity pEntity);
	/**
	 * <b><i>WARNING:</i> This function should be called from within
	 * {@link RunnableHandler#postRunnable(Runnable)} which is registered
	 * to a {@link Scene} or the {@link Engine} itself, because otherwise
	 * it may throw an {@link IndexOutOfBoundsException} in the
	 * Update-Thread or the GL-Thread!</b>
	 */
	public IEntity detachChild(final IEntityMatcher pEntityMatcher);
	/**
	 * <b><i>WARNING:</i> This function should be called from within
	 * {@link RunnableHandler#postRunnable(Runnable)} which is registered
	 * to a {@link Scene} or the {@link Engine} itself, because otherwise
	 * it may throw an {@link IndexOutOfBoundsException} in the
	 * Update-Thread or the GL-Thread!</b>
	 */
	public boolean detachChildren(final IEntityMatcher pEntityMatcher);

	public void detachChildren();

	public void callOnChildren(final IEntityParameterCallable pEntityParameterCallable);
	public void callOnChildren(final IEntityParameterCallable pEntityParameterCallable, final IEntityMatcher pEntityMatcher);

	public void registerUpdateHandler(final IUpdateHandler pUpdateHandler);
	public boolean unregisterUpdateHandler(final IUpdateHandler pUpdateHandler);
	public boolean unregisterUpdateHandlers(final IUpdateHandlerMatcher pUpdateHandlerMatcher);
	public void clearUpdateHandlers();

	public void registerEntityModifier(final IEntityModifier pEntityModifier);
	public boolean unregisterEntityModifier(final IEntityModifier pEntityModifier);
	public boolean unregisterEntityModifiers(final IEntityModifierMatcher pEntityModifierMatcher);
	public void clearEntityModifiers();

	public void setUserData(Object pUserData);
	public Object getUserData();

	public void toString(final StringBuilder pStringBuilder);

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	public interface IEntityMatcher extends IMatcher<IEntity> {
		// ===========================================================
		// Constants
		// ===========================================================

		// ===========================================================
		// Methods
		// ===========================================================

		@Override
		public boolean matches(final IEntity pEntity);
	}

	public interface IEntityParameterCallable extends ParameterCallable<IEntity> {
		// ===========================================================
		// Constants
		// ===========================================================

		// ===========================================================
		// Methods
		// ===========================================================

		@Override
		public void call(final IEntity pEntity);
	}
}
