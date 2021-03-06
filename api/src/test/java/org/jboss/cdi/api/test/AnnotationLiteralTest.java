package org.jboss.cdi.api.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Specializes;
import javax.enterprise.inject.TransientReference;
import javax.enterprise.inject.Typed;
import javax.enterprise.inject.Vetoed;
import javax.enterprise.inject.literal.InjectLiteral;
import javax.enterprise.inject.literal.NamedLiteral;
import javax.enterprise.inject.literal.QualifierLiteral;
import javax.enterprise.inject.literal.SingletonLiteral;
import javax.enterprise.util.AnnotationLiteral;
import javax.enterprise.util.Nonbinding;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import org.jboss.cdi.api.test.Foo.FooLiteral;
import org.testng.annotations.Test;

@Foo(name = "pete")
public class AnnotationLiteralTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullMemberValueOnHashCode() {
        new FooLiteral(null).hashCode();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullMemberValueOnEquals1() {
        new FooLiteral(null).equals(AnnotationLiteralTest.class.getAnnotation(Foo.class));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullMemberValueOnEquals2() {
        new FooLiteral(null).equals(new FooLiteral(null));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullMemberValueOnToString() {
        new FooLiteral(null).hashCode();
    }

    @Test
    public void testNewLiteral() {
        New literal = New.Literal.INSTANCE;
        assertEquals(literal.value(), New.class);
        assertEquals(New.Literal.of(Boolean.class).value(), Boolean.class);
    }

    @SuppressWarnings("serial")
    @Test
    public void testDefaultLiteral() {
        assertEquals(new AnnotationLiteral<Default>() {
        }, Default.Literal.INSTANCE);
    }

    @SuppressWarnings("serial")
    @Test
    public void testAnyLiteral() {
        assertEquals(new AnnotationLiteral<Any>() {
        }, Any.Literal.INSTANCE);
    }

    @SuppressWarnings("serial")
    @Test
    public void testNonbindingLiteral() {
        assertEquals(new AnnotationLiteral<Nonbinding>() {
        }, Nonbinding.Literal.INSTANCE);
    }

    @Test
    public void testTypedLiteral() {
        assertTrue(Typed.Literal.INSTANCE.value().length == 0);
        assertTrue(Typed.Literal.of(new Class[] { String.class }).value()[0] == String.class);
    }

    @SuppressWarnings("serial")
    @Test
    public void testAlternativeLiteral() {
        assertEquals(new AnnotationLiteral<Alternative>() {
        }, Alternative.Literal.INSTANCE);
    }

    @Test
    public void testNamedLiteral() {
        assertEquals(NamedLiteral.INSTANCE.value(), "");
        assertEquals(NamedLiteral.of("foo").value(), "foo");
    }

    @SuppressWarnings("serial")
    @Test
    public void testQualifierLiteral() {
        assertEquals(new AnnotationLiteral<Qualifier>() {
        }, QualifierLiteral.INSTANCE);
    }

    @SuppressWarnings("serial")
    @Test
    public void testSingletonLiteral() {
        assertEquals(new AnnotationLiteral<Singleton>() {
        }, SingletonLiteral.INSTANCE);
    }

    @Test
    public void testInitializedLiteral() {
        assertEquals(Initialized.Literal.of(RequestScoped.class).value(), RequestScoped.class);
    }

    @Test
    public void testDestroyedLiteral() {
        assertEquals(Destroyed.Literal.of(ConversationScoped.class).value(), ConversationScoped.class);
    }

    @SuppressWarnings("serial")
    @Test
    public void testApplicationScopedLiteral() {
        assertEquals(new AnnotationLiteral<ApplicationScoped>() {
        }, ApplicationScoped.Literal.INSTANCE);
    }

    @SuppressWarnings("serial")
    @Test
    public void testRequestScopedLiteral() {
        assertEquals(new AnnotationLiteral<RequestScoped>() {
        }, RequestScoped.Literal.INSTANCE);
    }

    @SuppressWarnings("serial")
    @Test
    public void testSessionScopedLiteral() {
        assertEquals(new AnnotationLiteral<SessionScoped>() {
        }, SessionScoped.Literal.INSTANCE);
    }

    @SuppressWarnings("serial")
    @Test
    public void testConversationScopedLiteral() {
        assertEquals(new AnnotationLiteral<ConversationScoped>() {
        }, ConversationScoped.Literal.INSTANCE);
    }

    @SuppressWarnings("serial")
    @Test
    public void testDependentLiteral() {
        assertEquals(new AnnotationLiteral<Dependent>() {
        }, Dependent.Literal.INSTANCE);
    }
    
    @SuppressWarnings("serial")
    @Test
    public void testVetoedLiteral() {
        assertEquals(new AnnotationLiteral<Vetoed>() {
        }, Vetoed.Literal.INSTANCE);
    }
    
    @SuppressWarnings("serial")
    @Test
    public void testInjectLiteral() {
        assertEquals(new AnnotationLiteral<Inject>() {
        }, InjectLiteral.INSTANCE);
    }
    
    @SuppressWarnings("serial")
    @Test
    public void testSpecializesLiteral() {
        assertEquals(new AnnotationLiteral<Specializes>() {
        }, Specializes.Literal.INSTANCE);
    }
    
    @SuppressWarnings("serial")
    @Test
    public void testTransientReferenceLiteral() {
        assertEquals(new AnnotationLiteral<TransientReference>() {
        }, TransientReference.Literal.INSTANCE);
    }

}
