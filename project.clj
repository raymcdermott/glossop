(defproject io.nervous/glossop "0.2.0"
  :description "Miscellaneous Clojure utilities"
  :url "https://github.com/nervous-systems/glossop"
  :license {:name "Unlicense" :url "http://unlicense.org/UNLICENSE"}
  :scm {:name "git" :url "https://github.com/nervous-systems/glossop"}
  :deploy-repositories [["clojars" {:creds :gpg}]]
  :signing {:gpg-key "moe@nervous.io"}
  :global-vars {*warn-on-reflection* true}
  :source-paths ["src" "test"]
  :dependencies
  [[org.clojure/clojure    "1.10.0-beta8"]
   [org.clojure/core.async "1.10.439"]
   [org.clojure/clojurescript  "1.10.439"]]
  :clean-targets ["target" "out"]
  :cljsbuild
  {:builds [{:id "glossop"
             :source-paths ["src"]
             :compiler {:output-to "out/glossop.js"
                        :output-dir "out"
                        :target :nodejs
                        :optimizations :none
                        :source-map true}}]}
  :profiles
  {:dev {:dependencies
         [[com.cemerick/piggieback "0.2.1"]
          [org.clojure/tools.nrepl "0.2.10"]]
         :repl-options {:nrepl-middleware
                        [cemerick.piggieback/wrap-cljs-repl]}}})
