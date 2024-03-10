/**
 */
package com.vogella.emf.webpage.model.webpage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>web</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.vogella.emf.webpage.model.webpage.web#getName <em>Name</em>}</li>
 *   <li>{@link com.vogella.emf.webpage.model.webpage.web#getTitle <em>Title</em>}</li>
 *   <li>{@link com.vogella.emf.webpage.model.webpage.web#getDescription <em>Description</em>}</li>
 *   <li>{@link com.vogella.emf.webpage.model.webpage.web#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link com.vogella.emf.webpage.model.webpage.web#getPages <em>Pages</em>}</li>
 * </ul>
 *
 * @see com.vogella.emf.webpage.model.webpage.WebpagePackage#getweb()
 * @model
 * @generated
 */
public interface web extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.vogella.emf.webpage.model.webpage.WebpagePackage#getweb_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.vogella.emf.webpage.model.webpage.web#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see com.vogella.emf.webpage.model.webpage.WebpagePackage#getweb_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link com.vogella.emf.webpage.model.webpage.web#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.vogella.emf.webpage.model.webpage.WebpagePackage#getweb_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.vogella.emf.webpage.model.webpage.web#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Keywords</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keywords</em>' attribute.
	 * @see #setKeywords(String)
	 * @see com.vogella.emf.webpage.model.webpage.WebpagePackage#getweb_Keywords()
	 * @model
	 * @generated
	 */
	String getKeywords();

	/**
	 * Sets the value of the '{@link com.vogella.emf.webpage.model.webpage.web#getKeywords <em>Keywords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Keywords</em>' attribute.
	 * @see #getKeywords()
	 * @generated
	 */
	void setKeywords(String value);

	/**
	 * Returns the value of the '<em><b>Pages</b></em>' containment reference list.
	 * The list contents are of type {@link com.vogella.emf.webpage.model.webpage.WebPage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' containment reference list.
	 * @see com.vogella.emf.webpage.model.webpage.WebpagePackage#getweb_Pages()
	 * @model containment="true"
	 * @generated
	 */
	EList<WebPage> getPages();

} // web
