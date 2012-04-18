/*******************************************************************************
 * Copyright (c) 2012 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.persistence.jpa.jpql;

import org.eclipse.persistence.jpa.jpql.util.iterator.IterableListIterator;

/**
 * A refactoring delta contains an ordered collection of {@link TextEdit}. The order is based on the
 * offset of those {@link TextEdit} objects: from the biggest offset to the smallest offset. This
 * will allow the invoker to perform the refactoring by replacing the old values by the new values
 * by following that order.
 *
 * @see BasicRefactoringTool
 *
 * @version 2.4
 * @since 2.4
 * @author Pascal Filion
 */
public interface RefactoringDelta {

	/**
	 * Applies the changes to the JPQL query and returns the refactoring operations. The list of {@link
	 * TextEdit} will be cleared.
	 */
	String applyChanges();

	/**
	 * Determines whether at least one {@link TextEdit} was added.
	 *
	 * @return <code>true</code> if there is at least one {@link TextEdit}; <code>false</code> otherwise
	 */
	boolean hasTextEdits();

	/**
	 * Returns the number of {@link TextEdit} objects that have been added.
	 *
	 * @return The count of {@link TextEdit} objects
	 */
	int size();

	/**
	 * Returns the collection of {@link TextEdit} objects that have been added during one or several
	 * refactoring operations. The collection has been ordered where the {@link TextEdit}'s offset
	 * are in reverse order, i.e. from the biggest to the smallest values.
	 *
	 * @return The ordered collection of {@link TextEdit} objects
	 */
	IterableListIterator<TextEdit> textEdits();
}