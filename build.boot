(def project 'sole)
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          :source-paths   #{"test"}
          :dependencies   '[[org.clojure/clojure "1.8.0"]
                            [boot/core "2.7.2" :scope "test"]
                            [metosin/boot-alt-test "0.3.2" :scope "test"]])

(task-options!
 pom {:project     project
      :version     version
      :description "A Boot build framework"
      :url         "https://github.com/RadicalZephyr/sole"
      :scm         {:url "https://github.com/RadicalZephyr/sole"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[adzerk.boot-test :refer [test]])
