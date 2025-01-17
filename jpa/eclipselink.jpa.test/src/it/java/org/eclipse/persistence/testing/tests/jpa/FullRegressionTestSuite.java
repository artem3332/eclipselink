/*
 * Copyright (c) 1998, 2022 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 1998, 2022 IBM Corporation. All rights reserved.
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
//     06/16/2009-2.0 Guy Pelletier
//       - 277039: JPA 2.0 Cache Usage Settings
//     01/19/2010-2.1 Guy Pelletier
//       - 211322: Add fetch-group(s) support to the EclipseLink-ORM.XML Schema
//     03/23/2011-2.3 Guy Pelletier
//       - 337323: Multi-tenant with shared schema support (part 1)
//     06/25/2014-2.5.2 Rick Curtis
//       - 438177: Test M2M map
//     08/11/2014-2.5 Rick Curtis
//       - 440594: Tolerate invalid NamedQuery at EntityManager creation.
//     08/18/2014-2.5 Jody Grassel (IBM Corporation)
//       - 440802: xml-mapping-metadata-complete does not exclude @Entity annotated entities
package org.eclipse.persistence.testing.tests.jpa;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.AdvancedJPAJunitTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.AdvancedJunitTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.CacheImplJUnitTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.CallbackEventJUnitTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.EntityManagerJUnitTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.ExtendedPersistenceContextJUnitTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.JoinedAttributeAdvancedJunitTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.MetadataCachingTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.NamedQueryJUnitTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.OptimisticConcurrencyJUnitTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.OptimisticLockForceIncrementTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.PersistenceUnitProcessorTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.PessimisticLockEntityRefreshTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.PessimisticLockingExtendedScopeTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.QueryCastTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.ReportQueryAdvancedJUnitTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.ReportQueryConstructorExpressionTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.ReportQueryMultipleReturnTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.SQLResultSetMappingTestSuite;
import org.eclipse.persistence.testing.tests.jpa.advanced.UpdateAllQueryAdvancedJunitTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.compositepk.AdvancedCompositePKJunitTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.concurrency.ConcurrencyTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.concurrency.LifecycleJUnitTest;
import org.eclipse.persistence.testing.tests.jpa.advanced.fetchgroup.AdvancedFetchGroupJunitTest;
import org.eclipse.persistence.testing.tests.jpa.config.ConfigPUTestSuite;
import org.eclipse.persistence.testing.tests.jpa.ddlgeneration.DDLGenerationExtendTablesJUnitTestSuite;
import org.eclipse.persistence.testing.tests.jpa.ddlgeneration.DDLGenerationJUnitTestSuite;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.FetchGroupAPITests;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.FetchGroupMergeWithCacheTests;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.FetchGroupTrackerWeavingTests;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.NestedDefaultFetchGroupTests;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.NestedFetchGroupTests;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.NestedNamedFetchGroupTests;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.SimpleDefaultFetchGroupTests;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.SimpleFetchGroupTests;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.SimpleNamedFetchGroupTests;
import org.eclipse.persistence.testing.tests.jpa.fetchgroups.SimpleSerializeFetchGroupTests;
import org.eclipse.persistence.testing.tests.jpa.inheritance.DeleteAllQueryInheritanceJunitTest;
import org.eclipse.persistence.testing.tests.jpa.inheritance.EntityManagerJUnitTestCase;
import org.eclipse.persistence.testing.tests.jpa.inheritance.JoinedAttributeInheritanceJunitTest;
import org.eclipse.persistence.testing.tests.jpa.inheritance.LifecycleCallbackJunitTest;
import org.eclipse.persistence.testing.tests.jpa.inheritance.MixedInheritanceJUnitTestCase;
import org.eclipse.persistence.testing.tests.jpa.inheritance.ReportQueryMultipleReturnInheritanceTestSuite;
import org.eclipse.persistence.testing.tests.jpa.inheritance.TablePerClassInheritanceDDLTest;
import org.eclipse.persistence.testing.tests.jpa.inheritance.TablePerClassInheritanceJUnitTest;
import org.eclipse.persistence.testing.tests.jpa.inherited.EmbeddableSuperclassJunitTest;
import org.eclipse.persistence.testing.tests.jpa.inherited.InheritedCallbacksJunitTest;
import org.eclipse.persistence.testing.tests.jpa.inherited.InheritedModelJunitTest;
import org.eclipse.persistence.testing.tests.jpa.inherited.OrderedListAttributeChangeTrackingJunitTest;
import org.eclipse.persistence.testing.tests.jpa.inherited.OrderedListJunitTest;
import org.eclipse.persistence.testing.tests.jpa.jpql.AdvancedQueryTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLComplexAggregateTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLComplexTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLExamplesTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLInheritanceTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLModifyTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLParameterTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLQueryHelperTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLSimpleTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLUnitTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitJPQLValidationTestSuite;
import org.eclipse.persistence.testing.tests.jpa.jpql.JUnitNativeQueryTestSuite;
import org.eclipse.persistence.testing.tests.jpa.plsql.PLSQLTestSuite;
import org.eclipse.persistence.testing.tests.jpa.plsql.XMLPLSQLTestSuite;
import org.eclipse.persistence.testing.tests.jpa.xml.EntityMappingsJUnitTestSuite;

public class FullRegressionTestSuite extends TestSuite {

    public static Test suite() {
        TestSuite fullSuite = new TestSuite();
        fullSuite.setName("FullRegressionTestSuite");

        // Advanced model
        TestSuite suite = new TestSuite();
        suite.setName("advanced");
        suite.addTest(LifecycleJUnitTest.suite());
        suite.addTest(ConcurrencyTest.suite());
        suite.addTest(CacheImplJUnitTest.suite());
        suite.addTest(CallbackEventJUnitTestSuite.suite());
        suite.addTest(IsolatedHashMapTest.suite());
        suite.addTest(EntityManagerJUnitTestSuite.suite());
        suite.addTest(SQLResultSetMappingTestSuite.suite());
        suite.addTest(JoinedAttributeAdvancedJunitTest.suite());
        suite.addTest(ReportQueryMultipleReturnTestSuite.suite());
        suite.addTest(ReportQueryAdvancedJUnitTest.suite());
        suite.addTest(ExtendedPersistenceContextJUnitTestSuite.suite());
        suite.addTest(ReportQueryConstructorExpressionTestSuite.suite());
        suite.addTest(OptimisticConcurrencyJUnitTestSuite.suite());
        suite.addTest(AdvancedJPAJunitTest.suite());
        suite.addTest(AdvancedJunitTest.suite());
        suite.addTest(AdvancedCompositePKJunitTest.suite());
        suite.addTest(AdvancedFetchGroupJunitTest.suite());
        suite.addTest(PessimisticLockingExtendedScopeTestSuite.suite());
        suite.addTest(PessimisticLockEntityRefreshTestSuite.suite());
        suite.addTest(UpdateAllQueryAdvancedJunitTest.suite());
        suite.addTest(MetadataCachingTestSuite.suite());
        suite.addTest(OptimisticLockForceIncrementTestSuite.suite());
        suite.addTest(ConfigPUTestSuite.suite());
        suite.addTest(NamedQueryJUnitTest.suite());
        fullSuite.addTest(suite);

        // Inheritance model.
        suite = new TestSuite();
        suite.setName("inheritance");
        suite.addTest(LifecycleCallbackJunitTest.suite());
        suite.addTest(DeleteAllQueryInheritanceJunitTest.suite());
        suite.addTest(EntityManagerJUnitTestCase.suite());
        suite.addTest(MixedInheritanceJUnitTestCase.suite());
        suite.addTest(JoinedAttributeInheritanceJunitTest.suite());
        suite.addTest(TablePerClassInheritanceJUnitTest.suite());
        suite.addTest(TablePerClassInheritanceDDLTest.suite());
        suite.addTest(ReportQueryMultipleReturnInheritanceTestSuite.suite());
        fullSuite.addTest(suite);

        // Inherited model.
        suite = new TestSuite();
        suite.setName("inherited");
        suite.addTest(OrderedListJunitTest.suite());
        suite.addTest(OrderedListAttributeChangeTrackingJunitTest.suite());
        suite.addTest(InheritedModelJunitTest.suite());
        suite.addTest(InheritedCallbacksJunitTest.suite());
        suite.addTest(EmbeddableSuperclassJunitTest.suite());
        fullSuite.addTest(suite);

        return fullSuite;
    }

    public static TestSuite suite2() {
        TestSuite fullSuite = new TestSuite();

        // JPQL testing model.
        TestSuite suite = new TestSuite();
        suite.setName("jpql");
        suite.addTest(JUnitJPQLUnitTestSuite.suite());
        suite.addTest(JUnitJPQLSimpleTestSuite.suite());
        suite.addTest(JUnitJPQLComplexTestSuite.suite());
        suite.addTest(JUnitJPQLInheritanceTestSuite.suite());
        suite.addTest(JUnitJPQLValidationTestSuite.suite());
        suite.addTest(JUnitJPQLComplexAggregateTestSuite.suite());
        suite.addTest(JUnitJPQLParameterTestSuite.suite());
        suite.addTest(JUnitJPQLExamplesTestSuite.suite());
        suite.addTest(JUnitJPQLModifyTestSuite.suite());
        suite.addTest(JUnitJPQLQueryHelperTestSuite.suite());
        suite.addTest(AdvancedQueryTestSuite.suite());
        suite.addTest(JUnitNativeQueryTestSuite.suite());
        fullSuite.addTest(suite);

        fullSuite.addTest(PLSQLTestSuite.suite());
        fullSuite.addTest(XMLPLSQLTestSuite.suite());
        // Has security manager issues on some JVMs.
        //fullSuite.addTest(RemoteEntityManagerTestSuite.suite());

        return fullSuite;
    }

    public static TestSuite suite3() {
        TestSuite fullSuite = new TestSuite();

        // Fetch Groups tests.
        TestSuite suite = new TestSuite();
        suite.setName("FetchGroups");
        suite.addTest(FetchGroupAPITests.suite());
        suite.addTest(FetchGroupTrackerWeavingTests.suite());
        suite.addTest(SimpleDefaultFetchGroupTests.suite());
        suite.addTest(SimpleFetchGroupTests.suite());
        suite.addTest(SimpleNamedFetchGroupTests.suite());
        suite.addTest(SimpleSerializeFetchGroupTests.suite());
        suite.addTest(NestedDefaultFetchGroupTests.suite());
        suite.addTest(NestedFetchGroupTests.suite());
        suite.addTest(NestedNamedFetchGroupTests.suite());
        suite.addTest(FetchGroupMergeWithCacheTests.suite());
        fullSuite.addTest(suite);

        return fullSuite;
    }

    public static TestSuite suite4() {
        TestSuite fullSuite = new TestSuite();

        // XML model
        fullSuite.addTest(EntityMappingsJUnitTestSuite.suite());

        // DDL model
        fullSuite.addTest(DDLGenerationJUnitTestSuite.suite());
        fullSuite.addTest(DDLGenerationExtendTablesJUnitTestSuite.suite());

        // OSGi Deployment
        //try {
        //    fullSuite.addTestSuite(CompositeEnumerationTest.class);
        //} catch (Throwable ignore) {} // OSgi may not be on classpath.

        // JPA 2.0 Criteria JPQL model
        TestSuite suite = new TestSuite();
        suite.setName("Criteria");
        suite.addTest(org.eclipse.persistence.testing.tests.jpa.criteria.JUnitCriteriaUnitTestSuite.suite());
        suite.addTest(org.eclipse.persistence.testing.tests.jpa.criteria.AdvancedCompositePKJunitTest.suite());
        suite.addTest(org.eclipse.persistence.testing.tests.jpa.criteria.AdvancedCriteriaQueryTestSuite.suite());
        suite.addTest(org.eclipse.persistence.testing.tests.jpa.criteria.AdvancedQueryTestSuite.suite());
        suite.addTest(org.eclipse.persistence.testing.tests.jpa.criteria.JUnitCriteriaSimpleTestSuite.suite());
        // Addition of the following suite requires classpath work - as it currently does not allow the JPA Testing Browser.launch to run in the Eclipse IDE
        //suite.addTest(org.eclipse.persistence.testing.tests.jpa.criteria.JUnitCriteriaMetamodelTestSuite.suite());
        fullSuite.addTest(suite);

        fullSuite.addTest(QueryCastTestSuite.suite());

        // Persistence Unit Processor tests.
        fullSuite.addTest(PersistenceUnitProcessorTest.suite());

        return fullSuite;
    }
}
