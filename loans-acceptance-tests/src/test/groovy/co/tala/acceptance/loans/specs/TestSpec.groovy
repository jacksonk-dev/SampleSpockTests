package co.tala.acceptance.loans.specs

import spock.lang.Narrative

//@Retention & @Target come from here
// import java.lang.annotation.*
// import org.spockframework.runtime.extension.ExtensionAnnotation

import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll
// import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension

// import org.spockframework.runtime.model.SpecInfo
// import org.spockframework.runtime.model.FeatureInfo
// import org.spockframework.runtime.model.MethodInfo

// @Retention(RetentionPolicy.RUNTIME)
// @Target([ElementType.TYPE, ElementType.METHOD])
// @ExtensionAnnotation(GezakoStatusExtension)
// public @interface GezakoStatus {

// }

// class GezakoStatusExtension extends AbstractAnnotationDrivenExtension<GezakoStatus> {
//   void visitSpecAnnotation(GezakoStatus annotation, SpecInfo spec) {
    
//   }

//   void visitFeatureAnnotation(GezakoStatus annotation, FeatureInfo feature) {
    
//   }

//   void visitSpec(SpecInfo spec) {
    
//   }
// }

@Unroll
@Narrative("featureId: 4bTMxCajoDGm6qCdDf2T")
@Title("User does sth")
class TestSpecAgain extends Specification {
    def "Positive Automated Test"() {
      given: "accc"

      when: "www"

      then: "ttt"
          1 == 1

      reportInfo "g_status: Automated, g_type: Positive"
      // gezakoStatus "Automated"
      // gezakoTitle "Something"
    }

    def "Negative Automated Test"() {
      given: "accc"

      when: "www"

      then: "ttt"
          1 == 1

      reportInfo "g_status: Automated, g_type: Negative"
    }

    def "Negative Manual Test"() {
      given: "accc"

      when: "www"

      then: "ttt"
          1 == 1

      reportInfo "g_status: Manual, g_type: Negative"
    }

    def "Positive Manual Test"() {
      given: "accc"

      when: "www"

      then: "tttt"
          1 == 1

      reportInfo "g_status: Manual, g_type: Positive"
    }

    def "No big deal tests"() {
      given: "accc"

      when: "www"

      then: "ttt"
          1 == 1

      reportInfo "g_status: Manual, g_type: Positive"
    }

    def "It works my nigga"() {
      given: "this"

      when: "that"

      then: "something should happen"
          1 == 1

      reportInfo "g_status: Manual, g_type: Positive"
    }
}
