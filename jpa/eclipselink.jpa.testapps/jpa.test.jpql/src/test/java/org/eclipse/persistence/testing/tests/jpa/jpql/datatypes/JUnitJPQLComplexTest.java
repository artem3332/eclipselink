/*
 * Copyright (c) 1998, 2022 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
//
//     04/11/2017-2.6 Will Dazey
//       - 512386: Add constructor initialization with CONCAT test
//     01/23/2018-2.7 Will Dazey
//       - 530214: trim operation should not bind parameters
package org.eclipse.persistence.testing.tests.jpa.jpql.datatypes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.eclipse.persistence.sessions.DatabaseSession;
import org.eclipse.persistence.testing.framework.jpa.junit.JUnitTestCase;
import org.eclipse.persistence.testing.models.jpa.datatypes.DataTypesTableCreator;
import org.eclipse.persistence.testing.models.jpa.datatypes.WrapperTypes;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitDomainObjectComparer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * <b>Purpose</b>: Test complex EJBQL functionality.
 * <p>
 * <b>Description</b>: This class creates a test suite, initializes the database
 * and adds tests to the suite.
 * <p>
 * <b>Responsibilities</b>:
 * <ul>
 * <li> Run tests for complex EJBQL functionality
 * </ul>
 * @see JUnitDomainObjectComparer
 */

public class JUnitJPQLComplexTest extends JUnitTestCase {

    public JUnitJPQLComplexTest()
    {
        super();
    }

    public JUnitJPQLComplexTest(String name)
    {
        super(name);
    }

    @Override
    public String getPersistenceUnitName() {
        return "datatypes";
    }

    //This method is run at the end of EVERY test case method
    @Override
    public void tearDown()
    {
        clearCache();
    }

    //This suite contains all tests contained in this class
    public static Test suite()
    {
        TestSuite suite = new TestSuite();
        suite.setName("JUnitJPQLComplexTest");
        suite.addTest(new JUnitJPQLComplexTest("testSetup"));

        List<String> tests = new ArrayList<>();
        tests.add("testFunctionInOrderBy");
        Collections.sort(tests);
        for (String test : tests) {
            suite.addTest(new JUnitJPQLComplexTest(test));
        }
        return suite;
    }

    /**
     * The setup is done as a test, both to record its failure, and to allow execution in the server.
     */
    public void testSetup() {
        clearCache();
        //get session to start setup
        DatabaseSession session = getPersistenceUnitServerSession();
        new DataTypesTableCreator().replaceTables(session);
    }

    public void testFunctionInOrderBy() {
        EntityManager em = createEntityManager();
        Query query = em.createQuery("SELECT wt FROM WrapperTypes wt order by wt.booleanData");
        // Cast to ensure that server test compile picks up class.
        List<WrapperTypes> result = query.getResultList();
        result.toString();
        closeEntityManager(em);
    }
}
